package com.example.teste_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ModelAndView abrirIndex(){
        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Olá visitante";
        mv.addObject("msg",mensagem);
        return mv;
    }

    @GetMapping("/sobre")
    public String abrirSobre(){
        return "sobre";
    }

    @GetMapping("/produto")
    public String abrirProduto(){
        return "produto";
    }

    @GetMapping("/contato")
    public String abrirContato(){
        return "sobre";
    }

    @PostMapping("/home")
    public ModelAndView postHome(@RequestParam ("nome") String nome){
        ModelAndView mv = new ModelAndView("index");
        String mensagem = "Olá, "+nome;
        mv.addObject("msg", mensagem);
        mv.addObject("nome","");

        return mv;
    }
}
