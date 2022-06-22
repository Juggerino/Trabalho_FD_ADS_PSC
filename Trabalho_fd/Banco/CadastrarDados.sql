INSERT INTO piloto (nomePiloto) 
            VALUE('Mateus'),
                 ('Maria'),
                 ('Joao'),
                 ('Maicon'),
                 ('Mama');

INSERT INTO pista (nomePista) 
            VALUE('Monaco'),
                 ('italia'),
                 ('japao');

INSERT INTO corrida (qtdVotas,melhorTempo,posicao,idPista,idPiloto) 
            VALUE(50,0.50,2,1,1),
                 (55,0.45,1,1,2),
                 (53,0.43,3,1,3),
                 (53,0.42,5,1,4),
                 (53,0.41,4,1,5);

