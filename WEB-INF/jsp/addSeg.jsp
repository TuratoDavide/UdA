<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
        html {
	  background-color: #fff;
	}

	body {
	  font-family: "Poppins", sans-serif;
	  height: 100vh;
	}

	a {
	  color: #92badd;
	  display:inline-block;
	  text-decoration: none;
	  font-weight: 400;
	}

	h2 {
	  text-align: center;
	  font-size: 16px;
	  font-weight: 600;
	  text-transform: uppercase;
	  display:inline-block;
	  margin: 40px 8px 10px 8px; 
	  color: #cccccc;
	}
        
        h1{
	  text-align: center;
	  font-weight: 600;
	  text-transform: uppercase;
	  display:inline-block;
	  margin: 40px 8px 10px 8px; 
	  color: #cccccc;
	}


	/* STRUCTURE */

	.wrapper {
	  display: flex;
	  align-items: center;
	  flex-direction: column; 
	  justify-content: center;
	  width: 100%;
	  min-height: 100%;
	  padding: 20px;
	}

	#formContent {
	  -webkit-border-radius: 10px 10px 10px 10px;
	  border-radius: 10px 10px 10px 10px;
	  background: #fff;
	  padding: 3%;
          padding-left: 15%;
          padding-right: 15%;
	  width: 100%;
          length: 100%;
	  position: relative;
	  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
	  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
	  text-align: center;
	}
	
	#pa {
		color: red;
	}


	/* TABS */

	h2.inactive, h1.inactive {
	  color: #4287f5;
	}

	h2.active, h1.active {
	  color: #4287f5;
	  border-bottom: 6px solid #4287f5;
	}



	/* FORM TYPOGRAPHY*/

	input[type=button], input[type=submit], input[type=reset] , label {
	  background-color: #4287f5;
	  border: none;
	  color: white;
	  padding: 15px 80px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  text-transform: uppercase;
	  font-size: 13px;
	  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
	  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
	  -webkit-border-radius: 5px 5px 5px 5px;
	  border-radius: 5px 5px 5px 5px;
	  margin: 5px 20px 40px 20px;
	  -webkit-transition: all 0.3s ease-in-out;
	  -moz-transition: all 0.3s ease-in-out;
	  -ms-transition: all 0.3s ease-in-out;
	  -o-transition: all 0.3s ease-in-out;
	  transition: all 0.3s ease-in-out;
	}

	input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover, select:hover  {
	  background-color: #2d5ba6;
	}

	input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
	  -moz-transform: scale(0.95);
	  -webkit-transform: scale(0.95);
	  -o-transform: scale(0.95);
	  -ms-transform: scale(0.95);
	  transform: scale(0.95);
	}

	input, select {
	  background-color: #f6f6f6;
	  border: none;
	  color: #0d0d0d;
	  padding: 15px 32px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  margin: 5px;
	  width: 85%;
	  border: 2px solid #f6f6f6;
	  -webkit-transition: all 0.5s ease-in-out;
	  -moz-transition: all 0.5s ease-in-out;
	  -ms-transition: all 0.5s ease-in-out;
	  -o-transition: all 0.5s ease-in-out;
	  transition: all 0.5s ease-in-out;
	  -webkit-border-radius: 5px 5px 5px 5px;
	  border-radius: 5px 5px 5px 5px;
	}


	input:focus, select:focus {
	  background-color: #fff;
	  border-bottom: 2px solid #4287f5;
	}

	input:placeholder, select:focus {
	  color: #cccccc;
	}

	.fadeInDown {
	  -webkit-animation-name: fadeInDown;
	  animation-name: fadeInDown;
	  -webkit-animation-duration: 1s;
	  animation-duration: 1s;
	  -webkit-animation-fill-mode: both;
	  animation-fill-mode: both;
	}

	@-webkit-keyframes fadeInDown {
	  0% {
		opacity: 0;
		-webkit-transform: translate3d(0, -100%, 0);
		transform: translate3d(0, -100%, 0);
	  }
	  100% {
		opacity: 1;
		-webkit-transform: none;
		transform: none;
	  }
	}

	@keyframes fadeInDown {
	  0% {
		opacity: 0;
		-webkit-transform: translate3d(0, -100%, 0);
		transform: translate3d(0, -100%, 0);
	  }
	  100% {
		opacity: 1;
		-webkit-transform: none;
		transform: none;
	  }
	}

	*:focus {
		outline: none;
	} 

	#icon {
	  width:60%;
	}

	* {
	  box-sizing: border-box;
	}
        </style>
</head>
<body>
          
	<div class="wrapper fadeInDown">
	  <div id="formContent">
		<!-- Tabs Titles -->
                <h1 class="active"> Inserisci una segnalazione </h1><br>
		<a class="active"> Per favore inserisci la segnalazione nei campi sottostanti </a>          
            <form:form method="POST" action="addSegnalazione" modelAttribute="segnalazioni">
                <form:input type="text" id="prodotto" class="fadeIn second" path="prodotto" placeholder="Prodotto" required="true"/>
                <form:input type="text" id="descrizione" class="fadeIn third" path="descrizione" placeholder="Descrizione" required="true"/>
                <form:input type="number" id="quantita" class="fadeIn third" path="quantita" placeholder="Quantità" min="1" value="1" required="true"/> 
                <select name="riferitaA" path="riferitaA" id="riferitaA" class="fadeIn third" placeholder="Riferito a">
                        <option value="Fornitori">Fornitori</option>
                        <option value="Clienti">Clienti</option>
                        <option value="Reparti">Reparti</option>
                </select>
                <input type="submit" class="fadeIn fourth" value="Aggiungi segnalazioni">
            </form:form>
	  </div>
	</div>
</body>
</html>