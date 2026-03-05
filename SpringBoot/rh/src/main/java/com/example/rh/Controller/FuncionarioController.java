package com.example.rh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rh.Model.Funcionario;
import com.example.rh.Repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository fr;

    @RequestMapping(value="/funcionario", method = RequestMethod.GET)
    public String abrirFuncionario(){
        return "funcionario/funcionario";
    }

    @RequestMapping(value = "/funcionario", method = RequestMethod.POST)
    public String gravarFuncionario (Funcionario funcionario){
        fr.save(funcionario);
        return "redirect:/funcionario";
    }
}
