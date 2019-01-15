--création du premier quiz
insert into quiz (id,name) values (1,'Burger Quiz');

	--création de la 1ere question
	insert into question (id,text,quiz_id,type_q) values (1,'Croyez-vous qu’il sera possible un jour de connaître l’avenir, de modifier le passe ?',1,'qcm');
		--choix de la question 1 
		insert into choice (id,value,question_id) values (1,'OUI',1);
		insert into choice (id,value,question_id) values (2,'NON',1);
		--reponse : Blanche fesse et les sept mains

	--création de la 2e question
	insert into question (id,text,quiz_id) values (2,'Voudriez-vous un jour voyager à travers une faille temporelle et retourner à l’époque où le LOSC était en Ligue 1',1,'qcm');
		--choix de la question 1 
		insert into choice (id,value,question_id) values (3,'OUI',2);
		insert into choice (id,value,question_id) values (4,'NON',2);
		--réponse : Les voyages dans le temps
		
	--création de la 2e question
	insert into question (id,text,quiz_id) values (3,'Quel prix seriez-vous prêt à débourser pour discuter avec vos ancêtres ?',1,'qcm');
		--choix de la question 1 
		insert into choice (id,value,question_id) values (5,'10 bitcoins',3);
		insert into choice (id,value,question_id) values (6,'100 bitcoins',3);
		insert into choice (id,value,question_id) values (7,'1000 bitcoins',3);
		--réponse : Les voyages dans le temps
	
			--création de la 2e question
	insert into question (id,text,quiz_id) values (4,'Quelle est la raison principale pour laquelle ce genre de technologie doit voir le jour ?',1,'qcm');
		--choix de la question 1 
		insert into choice (id,value,question_id) values (9,'Innovation',4);
		insert into choice (id,value,question_id) values (10,'Gagner la guerre',4);
		insert into choice (id,value,question_id) values (11,'Gagner au loto',4);
		insert into choice (id,value,question_id) values (12,'Connaitre son avenir',4);
		insert into choice (id,value,question_id) values (8,'Corriger le passé',4);
		--réponse : Les voyages dans le temps
		
		--création de la 2e question
	insert into question (id,text,quiz_id) values (5,'Donner le mot qui résume pour vous cette technologie.',1,'text');
--création de plusieurs quiz
--insert into quiz (id,name) values (2,'Sandwich Quiz');
--insert into quiz (id,name) values (3,'Panini Quiz');
--
----création du 4e quiz
--insert into quiz (id,name) values (4,'J2EE quiz');
--
--	insert into question (id,text,quiz_id) values (4,'Est-ce vous aimez le J2EE ?',4);
--		--choix de la question 1 du 4e quiz
--		insert into choice (id,value,question_id) values (13,'oui',4);
--		insert into choice (id,value,question_id) values (14,'non',4);
--		insert into choice (id,value,question_id) values (15,'merde',4);
		
--insert into quiz_instance(id,next_Question,quiz_id) values (1,false,1);
--		
----les réponses
--insert into answer (id,choice_id,quiz_instance_id) values(1,2,1);
--insert into answer (id,choice_id,quiz_instance_id) values(2,2,1);
--insert into answer (id,choice_id,quiz_instance_id) values(3,4,1);
--insert into answer (id,choice_id,quiz_instance_id) values(4,1,1);
--
--insert into answer (id,choice_id,quiz_instance_id) values(5,13,null);
--insert into answer (id,choice_id,quiz_instance_id) values(6,13,null);
--insert into answer (id,choice_id,quiz_instance_id) values(7,13,null);
--insert into answer (id,choice_id,quiz_instance_id) values(8,13,null);
--insert into answer (id,choice_id,quiz_instance_id) values(9,13,null);
--insert into answer (id,choice_id,quiz_instance_id) values(10,14,null);
--insert into answer (id,choice_id,quiz_instance_id) values(11,14,null);
--insert into answer (id,choice_id,quiz_instance_id) values(12,14,null);
--insert into answer (id,choice_id,quiz_instance_id) values(13,15,null);
--insert into answer (id,choice_id,quiz_instance_id) values(14,15,null);



--insert into utilisateur (id,mail,newsletter) values(1,'jl@mail.fr',true);