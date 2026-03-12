package com.example.sistema_de_manutencao.controller;
import com.example.sistema_de_manutencao.model.Ativos;
import com.example.sistema_de_manutencao.service.AtivosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ativos")
public class AtivosController {

    @Autowired
    private AtivosService service;

    @GetMapping
    public String listar(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("ativos", service.listar());
        return "app/ativo/ativo";
    }

    @GetMapping("/novo")
    public String novo(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("ativo", new Ativos());
        return "app/ativo/form-ativo";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("ativo", service.buscarPorId(id));
        return "app/ativo/form-ativo";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Ativos ativo, Model model) {
        try {
            service.salvar(ativo);
            return "redirect:/ativos";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/ativo/form-ativo";
        }
    }

    @PostMapping("/salvar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Ativos ativo, Model model) {
        try {
            ativo.setId(id);
            service.salvar(ativo);
            return "redirect:/ativos";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/ativo/form-ativo";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/ativos";
    }
}