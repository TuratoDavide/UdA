/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import javax.servlet.http.HttpSession;
import myapp.model.Accessi;
import myapp.model.Assembramento;
import myapp.model.Assembramento.Ruolo;
import myapp.model.AzioniCorrettive;
import myapp.model.ElementoTeam;
import myapp.model.Operazioni;
import myapp.model.Operazioni.Tipi;
import myapp.model.Segnalazioni;
import myapp.model.Team;
import myapp.model.Tipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myapp.model.Utenti;
import myapp.model.Verificazioni;
import myapp.service.AccessiService;
import myapp.service.AssembramentoService;
import myapp.service.AzioniCorrettiveService;
import myapp.service.OperazioniService;
import myapp.service.SegnalazioniService;
import myapp.service.TeamService;
import myapp.service.UtentiService;
import myapp.service.VerificazioniService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@ComponentScan("myapp.service")
public class AppController {

    @Autowired
    UtentiService service;
    @Autowired
    AccessiService aservice;
    @Autowired
    SegnalazioniService sservice;
    @Autowired
    AzioniCorrettiveService acservice;
    @Autowired
    TeamService tservice;
    @Autowired
    OperazioniService oservice;

    @Autowired
    AssembramentoService asservice;

    @Autowired
    VerificazioniService vservice;

    static final int INTERVALLO = 300;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String pagina1(ModelMap model) {
        Utenti utente = new Utenti();
        boolean bool = false;
        model.addAttribute("utente", utente);
        model.addAttribute("bool", bool);
        return "login";
    }

    @RequestMapping(value = "/controllo", method = RequestMethod.POST)
    public String controlloUtente(HttpSession hs, @ModelAttribute("utente") Utenti e, ModelMap model) {
        Utenti u = this.service.findById(e.getUsername());
        if (u != null && u.getPassword().equals(e.getPassword())) {
            Date d = new Date();
            Accessi a = new Accessi(d, u);
            this.aservice.saveAccesso(a);
            hs.setAttribute("utenteLoggato", u);
            hs.setMaxInactiveInterval(INTERVALLO);
            hs.setAttribute("accesso", a);
            model.addAttribute("utente", u);
            return "redirect:/lsegnalazioni";

        } else {
            boolean bool = true;
            model.addAttribute("bool", bool);
            return "login";
        }
    }

    @RequestMapping(value = "/lutenti", method = RequestMethod.GET)
    public String viewUtenti(HttpSession hs, ModelMap model) {
        List<Utenti> lutenti = service.findAllUtenti();
        model.addAttribute("lutenti", lutenti);

        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        model.addAttribute("utente", u);

        List<Assembramento> lasse = this.asservice.findAllAssembramento();
        model.addAttribute("lasse", lasse);

        model.addAttribute("bu", true);
        return "secondPage";

    }

    @RequestMapping(value = "/lsegnalazioni", method = RequestMethod.GET)
    public String viewSegnalazioni(HttpSession hs, ModelMap model) {
        List<Segnalazioni> lseg = sservice.findAllSegnalazioni();
        model.addAttribute("lseg", lseg);

        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        model.addAttribute("utente", u);

        model.addAttribute("bs", true);
        if (u.getTipo().equals(Tipo.Responsabile)) {
            List<AzioniCorrettive> lac = this.acservice.findAllAzioniCorrettive();
            model.addAttribute("lac", lac);
            return "secondPage";
        } else {
            return "secondPageN";
        }

    }

    @RequestMapping(value = "/lac", method = RequestMethod.GET)
    public String viewAzioniCorrettive(HttpSession hs, ModelMap model) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        model.addAttribute("utente", u);

        List<AzioniCorrettive> lac = this.acservice.findAllAzioniCorrettive();
        model.addAttribute("lac", lac);

        List<Verificazioni> lv = vservice.findAllVerificazioni();
        model.addAttribute("lv",lv);
        
        model.addAttribute("bac", true);
        if (u.getTipo().equals(Tipo.Responsabile)) {
            return "secondPage";
        } else {
            List<Assembramento> les = this.findTeam(hs);
            model.addAttribute("les", les);
            return "secondPageN";
        }

    }

    @RequestMapping(value = "/lver", method = RequestMethod.GET)
    public String viewVer(HttpSession hs, ModelMap model) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        model.addAttribute("utente", u);

        List<Verificazioni> lver = vservice.findAllVerificazioni();
        model.addAttribute("lver", lver);

        model.addAttribute("bv", true);
        if (u.getTipo().equals(Tipo.Responsabile)) {
            return "secondPage";
        }
        return "secondPageN";
    }

    @RequestMapping(value = "/addSeg", method = RequestMethod.POST)
    public String addSeg(HttpSession hs, ModelMap model) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        Segnalazioni seg = new Segnalazioni();
        model.addAttribute("segnalazioni", seg);
        model.addAttribute("utente", u);
        return "addSeg";
    }

    @RequestMapping(value = "/addSegnalazione", method = RequestMethod.POST)
    public String addSegnalazioni(HttpSession hs, @ModelAttribute("segnalazioni") Segnalazioni seg, ModelMap model) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        seg.setData(new Date());
        Accessi s = (Accessi) hs.getAttribute("accesso");
        Operazioni op = new Operazioni(Tipi.Inserimento, s);
        seg.setOp(op);
        oservice.saveOperazione(op);
        model.addAttribute("utente", u);
        this.sservice.saveSegnalazione(seg);
        return "redirect:/lsegnalazioni";
    }

    @RequestMapping(value = "/addT/{id}", method = RequestMethod.GET)
    public String addTe(HttpSession hs, ModelMap model, @PathVariable("id") int idSegnalazione) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        Segnalazioni s = sservice.findById(idSegnalazione);
        hs.setAttribute("segna", s);
        model.addAttribute("utente", u);
        List<Utenti> luteam = service.findAllUtenti();
        model.addAttribute("luteam", luteam);
        return "addTeam";
    }

    @RequestMapping(value = "/addTeam", method = RequestMethod.POST, params = {"username"})
    public String addTeam(HttpSession hs, ModelMap model, @RequestParam(value = "username") List<String> lus) {
        if (lus.size() < 4 || lus == null) {
            boolean bool = true;
            model.addAttribute("bool", bool);
            return "redirect:/lsegnalazioni";
        }

        Segnalazioni s = (Segnalazioni) hs.getAttribute("segna");
        AzioniCorrettive ac = new AzioniCorrettive(new Date(), s);
        acservice.saveAzioneCorrettiva(ac);
        Team t = new Team();
        t.setAcs(ac);
        t = tservice.saveTeam(t);
        t.setIdTeam(tservice.getLast());

        List<Utenti> lut = new ArrayList();
        List<Assembramento> lass = new ArrayList();
        for (String st : lus) {
            Utenti utente = service.findById(st);
            Assembramento a = new Assembramento(utente, t, Ruolo.Operatore);
            lut.add(utente);
            lass.add(a);

        }
        t.setAssembramenti(lass);
        tservice.updateTeam(t);
        model.addAttribute("team", lut);

        hs.setAttribute("utentiT", lut);
        hs.setAttribute("teamC", t);

        return "updateTeam";
    }

    @RequestMapping(value = "/updateTeam", method = RequestMethod.POST, params = {"ruolo"})
    public String updateTeam(HttpSession hs, ModelMap model, @RequestParam(value = "ruolo") List<String> ruoli) {
        Team t = (Team) hs.getAttribute("teamC");
        List<Utenti> lut = (List<Utenti>) hs.getAttribute("utentiT");
        List<Assembramento> lass = new ArrayList();
        int i = 0;
        for (String str : ruoli) {
            Assembramento a;
            if (str.equals("Responsabile")) {
                a = new Assembramento(lut.get(i), t, Ruolo.Responsabile);
            } else if (str.equals("Segretario")) {
                a = new Assembramento(lut.get(i), t, Ruolo.Segretario);
            } else {
                a = new Assembramento(lut.get(i), t, Ruolo.Operatore);
            }

            lass.add(a);
            i++;
        }
        t.setAssembramenti(lass);
        tservice.updateTeam(t);

        return "redirect:/lsegnalazioni";
    }

    @RequestMapping(value = "/addAzCor/{id}", method = RequestMethod.GET)
    public String addAzCor(HttpSession hs, ModelMap model, @PathVariable("id") int idAzione) {
        AzioniCorrettive ac = acservice.findById(idAzione);
        model.addAttribute("ac", ac);

        hs.setAttribute("azione", ac);

        return "addAzioneCorrettiva";
    }

    @RequestMapping(value = "/addAzc", method = RequestMethod.POST)
    public String addAzioniCorrettive(HttpSession hs, @ModelAttribute("ac") AzioniCorrettive ac, ModelMap model) {
        AzioniCorrettive acs = (AzioniCorrettive) hs.getAttribute("azione");
        acs.setDataFine(new Date());
        acs.setDescrizione(ac.getDescrizione());
        acservice.updateAzioneCorrettiva(acs);

        return "redirect:/lutenti";
    }

    @RequestMapping(value = "/lteam", method = RequestMethod.GET)
    public String viewTeam(HttpSession hs, ModelMap model) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        List<Assembramento> les = this.findTeam(hs);

        model.addAttribute("utente", u);
        model.addAttribute("les", les);
        model.addAttribute("bu", true);
        return "secondPageN";

    }

    @RequestMapping(value = "/addVer/{id}", method = RequestMethod.GET)
    public String addVer(HttpSession hs, ModelMap model, @PathVariable("id") int idAzione) {
        Utenti ut = (Utenti) hs.getAttribute("utenteLoggato");
        model.addAttribute("utente", ut);

        Verificazioni v = new Verificazioni();
        model.addAttribute("v", v);

        AzioniCorrettive ac = acservice.findById(idAzione);
        model.addAttribute("ac", ac);
        hs.setAttribute("ac", ac);
        return "addVerificazione";
    }

    @RequestMapping(value = "/addVerificazioni", method = RequestMethod.POST)
    public String addVerificazioni(HttpSession hs, @ModelAttribute("v") Verificazioni v, ModelMap model) {
        Utenti ut = (Utenti) hs.getAttribute("utenteLoggato");
        AzioniCorrettive ac = (AzioniCorrettive) hs.getAttribute("ac");

        Verificazioni ver = new Verificazioni(ut, ac, v.getNote(), v.getResponso());
        vservice.saveVerificazioni(ver);

        return "redirect:/lac";
    }

    public List<Assembramento> findTeam(HttpSession hs) {
        Utenti u = (Utenti) hs.getAttribute("utenteLoggato");
        List<Assembramento> la = asservice.findAllAssembramento();
        List<Assembramento> les = new ArrayList();
        for (Assembramento a : la) {
            if (u.getUsername().equals(a.getUsername().getUsername())) {
                for (Assembramento b : la) {
                    if (b.getIdTeam().getIdTeam() == a.getIdTeam().getIdTeam()) {
                        les.add(b);
                    }
                }
            }
        }
        return les;
    }

}
