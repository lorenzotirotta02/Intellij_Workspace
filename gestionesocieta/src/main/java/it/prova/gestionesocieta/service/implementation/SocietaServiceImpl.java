package it.prova.gestionesocieta.service.implementation;

import it.prova.gestionesocieta.exception.SocietaConRagioneSocialeGiaEsistenteException;
import it.prova.gestionesocieta.exception.SocietaHaDipendentiException;
import it.prova.gestionesocieta.model.Dipendente;
import org.apache.commons.lang3.StringUtils;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;
import it.prova.gestionesocieta.service.abstraction.SocietaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class SocietaServiceImpl implements SocietaService {

    @Autowired
    private SocietaRepository societaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void aggiungiSocieta(Societa societa){
        if(societaRepository.existsByRagioneSociale(societa.getRagioneSociale())){
            throw new SocietaConRagioneSocialeGiaEsistenteException("Ragione sociale già esistente");
        }
        else{
            societaRepository.save(societa);
        }
    }
    @Transactional
    @Override
    public void modificaSocieta(Societa societa) {
        societaRepository.save(societa);
    }

    @Transactional
    @Override
    public void eliminaSocieta(Long id) {
        List<Dipendente> dipendenti = societaRepository.findAllDipendentiBySocieta(id);
        if(!dipendenti.isEmpty()){
            throw new SocietaHaDipendentiException("La società che stai provando a rimuovere ha dipendenti");
        }
        else{
            societaRepository.deleteById(id);
        }
    }

    @Override
    public Optional<Societa> trovaSocietaPerId(Long id) {
        return societaRepository.findById(id);
    }
    @Override
    public List<Societa> findByExample(Societa example) {
        Map<String, Object> paramaterMap = new HashMap<String, Object>();
        List<String> whereClauses = new ArrayList<String>();

        StringBuilder queryBuilder = new StringBuilder("select s from Societa s where s.id = s.id ");

        if (StringUtils.isNotEmpty(example.getRagioneSociale())) {
            whereClauses.add(" s.ragioneSociale  like :ragioneSociale ");
            paramaterMap.put("ragioneSociale", "%" + example.getRagioneSociale() + "%");
        }
        if (StringUtils.isNotEmpty(example.getIndirizzo())) {
            whereClauses.add(" s.indirizzo like :indirizzo ");
            paramaterMap.put("indirizzo", "%" + example.getIndirizzo() + "%");
        }
        if (StringUtils.isNotEmpty(String.valueOf(example.getDataFondazione()))) {
            whereClauses.add(" s.dataFondazione like :dataFondazione ");
            paramaterMap.put("dataFondazione", "%" + example.getDataFondazione() + "%");
        }
        if (StringUtils.isNotEmpty(String.valueOf(example.getDataChiusura()))) {
            whereClauses.add(" s.dataChiusura like :dataChiusura ");
            paramaterMap.put("dataChiusura", "%" + example.getDataChiusura() + "%");
        }


        queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
        queryBuilder.append(StringUtils.join(whereClauses, " and "));
        TypedQuery<Societa> typedQuery = entityManager.createQuery(queryBuilder.toString(), Societa.class);

        for (String key : paramaterMap.keySet()) {
            typedQuery.setParameter(key, paramaterMap.get(key));
        }

        return typedQuery.getResultList();

    }

    @Override
    public List<Dipendente> trovaDipendentiPerSocieta(Long id){
        return societaRepository.findAllDipendentiBySocieta(id);
    }

    @Override
    public List<String> trovaTuttiIClientiPerSocieta(Long id){
        if(id == null || id < 1){
            throw new RuntimeException("Id non valido");
        }
        return societaRepository.findAllClientiBySocietaId(id);
    }
    @Override
    public List<String> trovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnno(){
        return societaRepository.findAllNomeSocietaWithProgettiDurataMaggioreDiUnAnno();
    }

    @Override
    public List<Societa> trovaTuttiIDipendentiConDataAssunzioneDopoDataFondazione() {
        return societaRepository.findAllByDipendenti_DataAssunzioneBeforeAndDataFondazione();
    }

}
