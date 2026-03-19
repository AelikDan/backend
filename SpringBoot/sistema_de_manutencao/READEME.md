
# Sistema de Gerenciamento de Estoque e Patrimônio — SENAI-SP

## Requisitos Funcionais (RF)

### Materiais
- RF01 - Cadastrar, editar, excluir e listar materiais.
- RF02 - Associar materiais a categorias.

### Categorias
- RF03 - Cadastrar, editar, excluir e listar categorias de materiais.

### Controle de Estoque
- RF04 - Registrar entradas e saídas de materiais no estoque.
- RF05 - Consultar histórico de movimentações.

### Ativos Patrimoniais
- RF06 - Cadastrar, editar, excluir e listar ativos patrimoniais.
- RF07 - Registrar localização e responsável de cada ativo.

### Acesso
- RF08 - Autenticar usuários via NIF e senha.
- RF09 - Proteger áreas internas contra acesso sem login.

---

## Requisitos Não Funcionais (RNF)

### Interface
- RNF01 - Seguir o manual de identidade visual do SENAI-SP.
- RNF02 - Interface responsiva e intuitiva.

### Segurança
- RNF03 - Validar dados antes de salvar no banco.
- RNF04 - Proteger rotas contra acessos não autorizados via sessão.

### Tecnologia
- RNF05 - Backend desenvolvido com Spring Boot.
- RNF06 - Banco de dados relacional (PostgreSQL).
- RNF07 - Interface web com Thymeleaf.

### Manutenção
- RNF08 - Código organizado em camadas (model, repository, service, controller).

## Sobre o Sistema

Este sistema foi desenvolvido para atender às necessidades de uma unidade escolar do SENAI-SP, 
onde o controle de materiais e equipamentos é essencial para o bom funcionamento dos laboratórios 
e salas de aula.

O sistema permite que a equipe administrativa acompanhe em tempo real a disponibilidade de 
materiais como ferramentas, equipamentos de informática e eletrônicos, além de gerenciar os 
ativos patrimoniais da instituição — como computadores, projetores e máquinas — registrando 
sua localização e responsável.

Com isso, a escola ganha mais controle, reduz perdas e facilita a gestão do patrimônio público.

### Sobre o banco de dados

O banco de dados ficou totalmente funcional, podendo ser manipulado pelo site e não necessariamente apenas pelo VS code

- Ao clicar em opções como criar nova movimentação, criar novo ativo, etc, o banco já atualiza e as informações são enviadas direta.