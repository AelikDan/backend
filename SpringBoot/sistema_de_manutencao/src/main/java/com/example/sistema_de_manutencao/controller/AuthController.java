package com.example.sistema_de_manutencao.controller;
import com.example.sistema_de_manutencao.service.FuncionarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("/login")
	public String loginPage() {
		return "fragments/auth/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String nif,
						@RequestParam String senha,
						HttpSession session,
						Model model) {

		boolean credenciaisOk = funcionarioService.autenticar(nif, senha);

		if (!credenciaisOk) {
			model.addAttribute("erro", "NIF ou senha inválidos.");
			return "fragments/auth/login";
		}

		session.setAttribute("usuarioLogado", true);
		session.setAttribute("nif", nif);
		return "redirect:/app";
	}

	@GetMapping("/cadastro")
	public String cadastroPage() {
		return "fragments/auth/cadastro";
	}

	@PostMapping("/cadastro")
	public String cadastro(@RequestParam String nome,
						   @RequestParam String nif,
						   @RequestParam String senha,
						   Model model) {
		try {
			funcionarioService.cadastrar(nome, nif, senha);
			return "redirect:/login";
		} catch (RuntimeException e) {
			model.addAttribute("erro", e.getMessage());
			return "fragments/auth/cadastro";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}