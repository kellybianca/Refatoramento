# Refatoramento - code smells corrigidos

**1 - Template Method** 
- Problema: Método duplicado nas classes: básico, premium e padrao.
- Solução: Criei uma nova subclasse e coloquei os metodos em uma mesma classe.
  
**2 - Duplicated Code**
  - Problema: Nome dos atributos iguais nas classes Filmes e Series.
 -  Solução: Criar uma superclasse Media com os atributos identicos e as classes Filmes e Series virarem subclasse da superclasse Media.
   
**3 -**


**Projeto original:** https://github.com/kellybianca/ProjetoDeSoftware
