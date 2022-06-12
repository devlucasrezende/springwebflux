Descrição:

Aplicação utilizando Spring Webflux onde é possível cadastrar e visualizar Playlists

🛠 Tecnologias usadas:
   Java,
   Spring Webflux,
   Reactive MongoDB,
   
O interessante da aplicação é verificar que no endpoint /events é possível setar um interval que determina quantos segundos uma resposta será dada ao cliente.
Durante esse período outras requisições podem ser feitas pois o Spring Webflux lida com tais requisições de forma reativa e não bloqueante!

PS: A controller não está sendo usada, pois as requisições chegam através do Handler e do Router!
