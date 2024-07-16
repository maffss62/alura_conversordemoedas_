Conversor de Moedas

Este é um conversor de moedas simples que realiza consultas em tempo real através da API ExchangeRate-API. Ele permite converter valores entre diversas moedas utilizando taxas de câmbio atualizadas.
Este conversor foi proposto como Chalenge pelo bootcamp Alura-Oracle One.

Funcionalidades:

- Converter de USD para BRL;
- Converter de BRL para USD;
- Converter de EUR para BRL;
- Converter de BRL para EUR;
- Converter de USD para EUR;
- Converter de BRL para GBP.

Interface:

Abaixo podemos ver a utilização do conversor. Nesse exemplo convertemos BRL para USD. Logo após o resultado, é possível fazer outras conversões. Caso não queira mais, insira a opção 7 para sair do conversor.

![image](https://github.com/user-attachments/assets/992bf03a-2004-4012-8f0a-870108c42b7a)

Tecnologias Utilizadas:

- Java;
- API ExchangeRate-API (https://www.exchangerate-api.com/).
  
Como Utilizar:

1. Clonar o Repositório:
    git clone (https://github.com/EdielsonKiel/Alura-ConversorDeMoedasChalenge.git)
    cd seu-repositorio
2. Configurar a API:
    Obtenha uma chave de API no ExchangeRate-API
    Substitua YOUR_API_KEY pela sua chave de API no código.
3. Compilar e Executar:
    javac -d bin src/br/com/edielson/conversordemoedas/*.java
    java -cp bin br.com.edielson.conversordemoedas.Principal
4. Interagir com o Conversor:
    Execute o programa e siga as instruções exibidas no menu.
    Selecione a opção desejada para a conversão de moedas.
    Insira o valor a ser convertido.

Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
