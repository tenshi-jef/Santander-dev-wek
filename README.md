# Santader-dev-week
API RESTful java com SpringBoot 

## Diagrama de classes 


```mermaid

classDiagram
    class User {
        +Account account
        +Features features
        +Card card
        +News news
    }
    
    class Account {
        +String number
        +String agency
        +Double balance
        +Double limit
    }
    
    class Features {
        +String pixIcon
        +String pixDescription
        +String pixDescriptionPay
        +String transferenceIcon
    }
    
    class Card {
        +String number
        +Double limit
    }
    
    class News {
        +List<String> list
    }
    
    User *-- Account
    User *-- Features
    User *-- Card
    User *-- News
    ```
  
