# sikulix-automations
Rotinas automatizadas utilizando a API do SikuliX.

---
## Automação Gmail
- Rotina para envio de email. Automação abre a página do Gmail, realiza o login seguido da autenticação em dois fatores e envia um email.
- Ao realizar a autenticação, o sikuli espera o usuário concluir a segunda etapa da verificação através do celular.

### Variáveis de ambiente
* LOCAL_PROJECT_PATH: Contém o caminho do diretório do projeto.
* USER_GMAIL: Contém o endereço do email
* PASSWORD_GMAIL: Contém a senha do email

---
## Automação Youtube
- Rotina de abertura do Youtube e da busca pela música Juno, da banda TesseracT, além da melhora de qualidade de imagem do vídeo para 1080p.
- Antes de realizar a ação de configurar o vídeo para 1080p, a automação espera todos os anúncios terminarem.