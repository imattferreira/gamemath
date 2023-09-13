## GameMath

### Setup

1. Antes de mais nada, certifique-se de possuir um banco MySQL ou SQL Server ativo, estando consigo suas credenciais.
2. Em seu banco de dados, crie um schema, com o nome que desejar (recomendamos `gamemath`)
3. Abra seu banco de dados em qualquer cliente de SQL, e rode as seguintes migrations, de acordo com o tipo de seu banco:
<details>
    <summary>MySQL</summary>

```sql
 CREATE TABLE records (
    id       INT            AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    points   INT
);
```

</details>
<details>
    <summary>SQL Server</summary>

```sql
 CREATE TABLE records (
    id          INT           IDENTITY(1,1) PRIMARY KEY,
    username    VARCHAR(255),
    points      INT
);
```

</details>
4. Abra o arquivo `Repository.java`, e altere os atributos `url`, `username` e `password` de acordo com o seu banco de dados, exemplo:

```java
public class Repository {
    private final String url = "jdbc:mysql://localhost:3306/gamemath";
    private final String username = "root";
    private final String password = "docker";

    // restante do conteúdo da classe
}
```

5. Rode o projeto a partir da classe `Main.java`
6. Pronto, o projeto já estará funcionando corretamente!
