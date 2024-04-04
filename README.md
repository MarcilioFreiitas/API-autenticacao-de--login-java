# 🚀 API de Validação de Login 🚀

Este projeto é uma API de validação de login desenvolvida para garantir a segurança e a autenticação eficaz dos usuários. Aqui estão alguns detalhes sobre o projeto:

## 📝 Descrição 📝

A API de Validação de Login é um serviço back-end projetado para autenticar usuários em uma aplicação. Ela recebe credenciais de login, como nome de usuário e senha, e retorna um token de autenticação se as credenciais forem válidas.

## 🎁 Recursos 🎁

1. **🔒 Autenticação Segura 🔒**: Utiliza algoritmos de hash e sal para proteger as senhas dos usuários.
2. **🔑 Geração de Token 🔑**: Gera um token de autenticação único para cada sessão de usuário válida.
3. **🔍 Verificação de Token 🔍**: Verifica o token de autenticação em cada solicitação subsequente para garantir que o usuário esteja autenticado.
4. **🛡️ Proteção contra Ataques de Força Bruta 🛡️**: Implementa medidas de segurança para prevenir ataques de força bruta.

## 💻 Tecnologias Utilizadas 💻

Este projeto foi desenvolvido usando Java e SpringBoot para o servidor back-end, e MySQL para o banco de dados.

## 🚀 Como Usar 🚀

Para usar esta API, você precisará enviar uma solicitação POST com as credenciais de login para o endpoint de login. Se as credenciais forem válidas, você receberá um token de autenticação que deverá ser incluído em todas as solicitações subsequentes.

Esperamos que você ache este projeto útil para suas necessidades de autenticação de usuário. Sinta-se à vontade para contribuir com melhorias e novos recursos! 🎉
