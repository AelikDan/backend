package com.example.sistema_de_manutencao.controller;
import com.example.sistema_de_manutencao.model.Materiais;
import com.example.sistema_de_manutencao.service.MateriaisService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materiais")
public class MateriaisController {

    @Autowired
    private MateriaisService service;

    @GetMapping
    public String listar(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("materiais", service.listar());
        return "app/materiais/materiais";
    }

    @GetMapping("/novo")
    public String novo(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("material", new Materiais());
        return "app/materiais/form-materiais";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("material", service.buscarPorId(id));
        return "app/materiais/form-materiais";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Materiais material, Model model) {
        try {
            service.salvar(material);
            return "redirect:/materiais";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/materiais/form-materiais";
        }
    }

    @PostMapping("/salvar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Materiais material, Model model) {
        try {
            material.setId(id);
            service.salvar(material);
            return "redirect:/materiais";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/materiais/form-materiais";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/materiais";
    }
}