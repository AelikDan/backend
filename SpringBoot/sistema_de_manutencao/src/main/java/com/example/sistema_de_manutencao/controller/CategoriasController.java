package com.example.sistema_de_manutencao.controller;
import com.example.sistema_de_manutencao.model.Categoria;
import com.example.sistema_de_manutencao.service.CategoriaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public String listar(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("categorias", service.listar());
        return "app/categorias/categorias";
    }

    @GetMapping("/novo")
    public String novo(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("categoria", new Categoria());
        return "app/categorias/form-categorias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("categoria", service.buscarPorId(id));
        return "app/categorias/form-categorias";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Categoria categoria, Model model) {
        try {
            service.salvar(categoria);
            return "redirect:/categorias";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/categorias/form-categorias";
        }
    }

    @PostMapping("/salvar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Categoria categoria, Model model) {
        try {
            categoria.setId(id);
            service.salvar(categoria);
            return "redirect:/categorias";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/categorias/form-categorias";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/categorias";
    }
}