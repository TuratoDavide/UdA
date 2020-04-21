<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .menu:hover .menu__link:not(:hover){
                color: #2d5ba6;
            }

            /* 
            =====
            MENU STYLES
            =====
            */

            /* core styles */

            .menu__list{
                display: flex;  
                text-align: center;
                padding-left: 0;
                margin-top: 0;
                margin-bottom: 0;
                list-style: none;  
            }

            .menu__group{
                flex-grow: 1;
            }

            .menu__link{
                display: block;
            }

            /* skin */

            .menu{
                background-color: #4287f5;
                box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .12), 0 1px 2px 0 rgba(0, 0, 0, .24);
                display: block;
            }

            .menu__link{
                padding: 2rem 1.5rem;

                font-weight: 700;
                color: #fff;
                text-decoration: none;
                text-transform: uppercase;
            }

            /* states */
            .menu__link:focus{
                outline: 2px solid #fff;
            }

            /* hover animation */

            .menu__link{
                position: relative;
                overflow: hidden;

                will-change: color;
                transition: color .25s ease-out;  
            }

            .menu__link::before, 
            .menu__link::after{
                content: "";
                width: 0;
                height: 3px;
                background-color: #fff;

                will-change: width;
                transition: width .1s ease-out;

                position: absolute;
                bottom: 0;
            }

            .menu__link::before{
                left: 50%;
                transform: translateX(-50%); 
            }

            .menu__link::after{
                right: 50%;
                transform: translateX(50%); 
            }

            .menu__link:hover::before, 
            .menu__link:hover::after{
                width: 100%;
                transition-duration: .2s;
            }


            body{
                font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto, Open Sans, Ubuntu, Fira Sans, Helvetica Neue, sans-serif;
                font-size: 1.6rem;
                margin: 0;
                min-height: 100vh;
                display: block;  
                flex-direction: column;
            }

            .page{
                box-sizing: border-box;

                width: 100%;  
                display: block;
                order: 1;
            }

            h1{
                text-align: center;
                font-weight: 600;
                text-transform: uppercase;
                display:inline-block;
                margin: 40px 8px 10px 8px; 
                color: #cccccc;
            }

            h1.active{
                color: #4287f5;
                border-bottom: 6px solid #4287f5;
            }

            h1.inactive, th {
                color: #4287f5;
            }
            td {
                color: #2d5ba6;
            }

            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                font-size: 100%;
                padding: 10px;
            }
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

            input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {
                background-color: #2d5ba6;
            }

            input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {
                -moz-transform: scale(0.95);
                -webkit-transform: scale(0.95);
                -o-transform: scale(0.95);
                -ms-transform: scale(0.95);
                transform: scale(0.95);
            }
            input {
                background-color: #f6f6f6;
                border: none;
                color: #0d0d0d;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 5px;
                width: 35%;
                border: 2px solid #f6f6f6;
                -webkit-transition: all 0.5s ease-in-out;
                -moz-transition: all 0.5s ease-in-out;
                -ms-transition: all 0.5s ease-in-out;
                -o-transition: all 0.5s ease-in-out;
                transition: all 0.5s ease-in-out;
                -webkit-border-radius: 5px 5px 5px 5px;
                border-radius: 5px 5px 5px 5px;
            }

            input:focus {
                background-color: #fff;
                border-bottom: 2px solid #4287f5;
            }

            input:placeholder {
                color: #cccccc;
            }

            table{
                text-align: center;
            }
        </style>
    </head>
    <body>

    <center><h1 class="active">Benvenuto ${utente.username}</h1></center>
    <div class="page">
        <nav class="menu">
            <ul class="menu__list">

                <li class="menu__group">
                    <a href="lsegnalazioni" class="menu__link">Le Segnalazioni</a>
                </li>

                <li class="menu__group">
                    <a href="lteam" class="menu__link">Team appartenenti</a>
                </li>

                <li class="menu__group">
                    <a href="lac" class="menu__link">Verifica azioni correttive</a>
                </li>
                <li class="menu__group">          
                    <a href="lver" class="menu__link">Lista verificazioni</a>
                </li>
            </ul>
        </nav>
    </div>
    <br>

    <c:if test="${bs}">
        <c:if test="${!empty lseg}">
            <%int j = 0;%>
            <center><table>
                    <tr>
                        <td>#</td>
                        <td>IdSegnalazione</td>
                        <td>Prodotto</td>
                        <td>Descrizione</td>
                        <td>Quantità</td>
                        <td>Riferito a</td>
                    </tr>
                    <c:forEach items="${lseg}" var="e" varStatus="pos">
                        <%boolean trovato = false;%>
                        <c:forEach items="${lac}" var="l">
                            <c:if test="${l.seg.getIdSegnalazione() == e.idSegnalazione}">
                                <%trovato = true;%>
                            </c:if>
                        </c:forEach>
                        <tr>
                            <td>${pos.index}</td>
                            <th>${e.idSegnalazione}</th>
                            <th>${e.prodotto}</th>
                            <th>${e.descrizione}</th>
                            <th>${e.quantita}</th>
                            <th>${e.riferitaA.name()}</th>
                        </tr>
                        <%j++;%>
                    </c:forEach>
                </table></center>
            <br>
        </c:if>
        <form:form method="POST" action="addSeg">            
            <center><input type="submit" class="fadeIn fourth" value="Aggiungi segnalazioni"></center>
            </form:form>
        </c:if>

    <c:if test="${bu}">
        <c:if test="${!empty les}">
            <center><table>
                    <tr>
                        <td>#</td>
                        <td>IdTeam</td>
                        <td>Username</td>
                        <td>Ruolo</td>
                    </tr>
                    <c:forEach items="${les}" var="e" varStatus="pos">
                        <tr>
                            <td>${pos.index}</td>
                            <th>${e.getIdTeam().getIdTeam()}</th>
                            <th>${e.username.getUsername()}</th>
                            <th>${e.ruolo.name()}</th>
                        </tr>
                    </c:forEach>
                </table></center>
            <br>
        </c:if>
    </c:if>

    <c:if test="${bac}">
        <c:if test="${!empty lac}">
            <center><table>
                    <tr>
                        <td>#</td>
                        <td>IdAzione</td>
                        <td>Descrizione</td>
                        <td>Data di inizio</td>
                        <td>Data di fine</td>
                        <td>Id Segnalazione</td>
                        <td>Team assegnato</td>
                        <td>Chiusura</td>
                        <td>Verifica</td>
                    </tr>

                    <c:forEach items="${lac}" var="e" varStatus="pos">
                        <%boolean tr = false;
                        %>
                        <c:forEach items="${les}" var="l">
                            <c:if test="${e.ts.getIdTeam() == l.getIdTeam().getIdTeam()}">
                                <%tr = true;%>
                            </c:if>
                        </c:forEach>
                        <%  if (tr) { %>
                        <tr>
                            <td>${pos.index}</td>
                            <th>${e.idAzione}</th>
                                <c:if test="${!empty e.descrizione}">
                                <th>${e.descrizione}</th>
                                </c:if>
                                <c:if test="${empty e.descrizione}">
                                <th>Senza descrizione</th>
                                </c:if>
                            <th>${e.dataInizio}</th>
                                <c:if test="${!empty e.dataFine}">
                                <th>${e.dataFine}</th>
                                </c:if>
                                <c:if test="${empty e.dataFine}">
                                <th>Non ancora finito</th>
                                </c:if>

                            <th>${e.seg.getIdSegnalazione()}</th>

                            <c:if test="${!empty e.ts}">
                                <th>${e.ts.getIdTeam()}</th>
                                </c:if>
                                <c:if test="${empty e.ts}">
                                <th>Team non creato</th>
                                </c:if>

                            <c:if test="${!empty e.dataFine}">
                                <th>Chiuso</th>
                                </c:if>
                                <c:if test="${empty e.dataFine}">
                                <th><a href="<c:url value='/addAzCor/${e.idAzione}' />" >Chiusura</a></th>
                                </c:if>

                            <c:if test="${!empty e.dataFine}">
                                <% boolean zr = false;%>
                                <c:forEach items="${lv}" var="h">
                                    <c:if test="${h.username.getUsername() == utente.username}">
                                        <c:if test="${h.azione.getIdAzione() == e.idAzione}">
                                            <%zr = true;%>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                                <%  if (zr) { %>
                                <th>X</th>
                                    <%} else { %> 
                                <th><a href="<c:url value='/addVer/${e.idAzione}' />" >✓</a></th>
                                    <% } %>
                                </c:if>
                                <c:if test="${empty e.dataFine}">
                                <th>X</th>
                                </c:if>    
                        </tr>
                        <% }%>

                    </c:forEach>
                </table></center>
            </c:if>
        </c:if>

    <c:if test="${bv}">
        <c:if test="${!empty lver}">
            <center><table>
                    <tr>
                        <th>#</th>
                        <th>Username</th>
                        <th>Azione</th>
                        <th>Note</th>
                        <th>Responso</th>
                    </tr>
                    <c:forEach items="${lver}" var="v" varStatus="pos">
                        <tr>	
                            <td>${pos.index}</td>
                            <td>${v.username.getUsername()}</td>
                            <td>${v.azione.getIdAzione()}</td>
                            <td>${v.note}</td>
                            <td>${v.responso}</td>
                        </tr>
                    </c:forEach>
                </table></center>
            </c:if>  
        </c:if>   

</body>

</hmtl>