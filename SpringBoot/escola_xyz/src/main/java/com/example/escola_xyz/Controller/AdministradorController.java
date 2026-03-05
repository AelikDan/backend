package com.example.escola_xyz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.escola_xyz.Repository.AdministadorRepository;
import com.example.escola_xyz.Repository.VerificaCadastroAdmRepository;
import com.example.escola_xyz.model.Administrador;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AdministradorController {

    // Permite a Transfomração de um OBJ-Java em Entidade de BD
    // Cada Obj Criado Vira uma Linha do BD
    @Autowired
    AdministadorRepository ar;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    //Verifica acesso e cadastro
    boolean acessoAdm = false;

    //Métodos
    // 1 - Para navegar na página de cadastro
    @GetMapping("/cadastrar-adm")
    public String acessoCadastroAdmPage() {
        return "cadastro/cadastrar-adm";
    }

    //Método para enviar o cadastro do Adm
    @PostMapping("/cadastrar-adm")
    public ModelAndView cadastrarAdmBD(Administrador adm, RedirectAttributes attributes) {
        boolean verificaCpf = vcar.existsById(adm.getCpf());
        if(verificaCpf == true){
            //obj adm => pega as irformações do formulário e cria um obj da classe adm
            //salva no bd
            ar.save(adm);

            String mensagem = "Cadastro Realizado com Sucesso";
            //log para o sistema
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe","verde");
        }
        else{
            String mensagem = "Cadastro não Permitido";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe","vermelho");
        }
        ModelAndView mv = new ModelAndView("redirect:/login-adm");
        
        return mv;
    }
    
    //método para página de login do adm
    @GetMapping("/login-adm")
    public String acessoLoginPageAdm() {
        return "login/login-adm";
    }
    
    //método para carregar a página interna após o login

    @PostMapping("acesso-adm")
    public ModelAndView acessoAdm(@RequestParam String cpf, @RequestParam String senha, RedirectAttributes attributes) {
        //TODO: process POST request
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");
        
        boolean verificaCpf = ar.existsById(cpf);
        boolean verificaSenha = ar.findByCpf(cpf).getSenha().equals(senha);
        if(verificaCpf && verificaSenha){
            acessoAdm = true;
        }
        else{
            String mensagem = "CPF ou Senha Incorreto";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe","vermelho");
            mv.setViewName("redirect:/login-adm");;
        }

        return mv;
    }
        // acessar a página interna

    @GetMapping("/interna-adm")
    public ModelAndView acessoInternaPageAdm (RedirectAttributes attributes) {
        String vaiPara  = "";
        if (acessoAdm) {
            vaiPara = "interna/interna-adm";
        }else{
            String mensagem = "Acesso não Permitido";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg",mensagem);
            attributes.addFlashAttribute("classe", "vermelha");
        }
        ModelAndView mv = new ModelAndView(vaiPara);
        return mv;
    }
    
    @GetMapping("/logoutAdm")
    public String logoutAdm(){
        acessoAdm = false;
        return "redirect:/login-adm";
    }
    
}