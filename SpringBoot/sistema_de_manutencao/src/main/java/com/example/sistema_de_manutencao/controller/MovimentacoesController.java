package com.example.sistema_de_manutencao.controller;
import com.example.sistema_de_manutencao.model.Movimentacoes;
import com.example.sistema_de_manutencao.service.MovimentacaoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public String listar(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("movimentacoes", service.listar());
        return "app/movimentacoes/movimentacoes";
    }

    @GetMapping("/novo")
    public String novo(HttpSession session, Model model) {
        if (session.getAttribute("usuarioLogado") == null) return "redirect:/login";
        model.addAttribute("movimentacao", new Movimentacoes());
        return "app/movimentacoes/form-movimentacao";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Movimentacoes movimentacao, Model model) {
        try {
            service.salvar(movimentacao);
            return "redirect:/movimentacoes";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "app/movimentacoes/form-movimentacao";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/movimentacoes";
    }
}