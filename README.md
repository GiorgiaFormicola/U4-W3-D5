# U4-W3-D5

Inizialmente avevo ho optato per la strategia SINGLE_TABLE per due motivi:
1.Le riviste ed i libri avevano pochi attributi non in comune;
2.Immaginando l'utilizzo dell'applicazione e soprattutto considerando i metodi di ricerca richiesti
a livello di prestazioni una SINGLE_TABLE poteva essere migliore come opzione così da evitare svariati JOIN per le
ricerche
Poi ho cambiato direzione in quanto non apprezzavo il fatto di non poter utilizzare vincoli NOT NULL:
per esempio non mi piaceva l'idea di poter creare un libro senza autore, per quanto mi rendo conto nella realtà
potrebbero esistere libri con autore anonimo.
Soprattutto ho immaginato la scalabilità di questa applicazione e pensando a possibili ulteriori entità da aggiungere
come elementi della libreria (es. DVD, CD, ecc.) ho ritenuto fosse meglio avere delle tabelle separate.
Per quanto riguarda le relazioni ho scelto due 1:N per i prestiti.
