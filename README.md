# Sistema com Banco de Dados Não-Relacional

## Formato do Projeto
- O projeto foi desenvolvido individualmente.
- O banco de dados utilizado é **MongoDB**, escolhido pela facilidade de armazenar documentos complexos em JSON, adequando-se ao modelo de dados do sistema.
- O back-end foi implementado em **Java com Spring Boot**, integrando diretamente com o MongoDB através do Spring Data MongoDB.

---

## Funcionalidades
O sistema implementa:

- **Estruturas de dados não-relacionais** compatíveis com o MongoDB, utilizando documentos e arrays.
- **CRUD completo**:
  - **Create**: Inserção de novos registros no banco.
  - **Read**: Consulta de registros, incluindo filtragem por campos específicos.
  - **Update**: Atualização de registros existentes.
  - **Delete**: Remoção de registros do banco.

Exemplo de estrutura de um documento no MongoDB:

```json
{
  "id": "1",
  "nome": "Renata Oliveira",
  "endereco": "Rua Teste, 123",
  "descricao": "Prestadora de serviços de tecnologia",
  "servicos": [
    {
      "nome": "Design Gráfico",
      "preco": 150.0,
      "avaliacoes": [
        {
          "cliente": "João",
          "nota": 5,
          "comentario": "Ótimo serviço!"
        }
      ]
    }
  ]
}
