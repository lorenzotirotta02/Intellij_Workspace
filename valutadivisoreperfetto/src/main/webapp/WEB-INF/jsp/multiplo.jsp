<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Multiplo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        p {
            font-size: 18px;
            margin: 20px 0;
        }
        a {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }
        a:hover {
            background-color: #0b7dda;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>Divisione effettuata!</h1>
    <p>Il numero ${dividendo} è in effetti un multiplo del numero ${divisore} e in esso è contenuto ${quoziente} volte</p>

    <a href="/">Torna alla domanda</a>
</div>
</body>
</html>