#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Articles
#------------------------------------------------------------

CREATE TABLE Articles(
        ar_id           Int NOT NULL ,
        ar_ref          Varchar (50) NOT NULL ,
        ar_nom          Varchar (50) NOT NULL ,
        ar_isHC         Bool NOT NULL ,
        ar_description  Text ,
        ar_image        Varchar (200) ,
        ar_dateCreation Date NOT NULL ,
        ar_isActif      Bool NOT NULL ,
        fa_id           Int NOT NULL ,
        mo_id           Int NOT NULL ,
        PRIMARY KEY (ar_id ) ,
        UNIQUE (ar_ref )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Familles
#------------------------------------------------------------

CREATE TABLE Familles(
        fa_id   int (11) Auto_increment  NOT NULL ,
        fa_code Varchar (10) NOT NULL ,
        fa_nom  Varchar (25) NOT NULL ,
        PRIMARY KEY (fa_id ) ,
        UNIQUE (fa_code )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Modeles
#------------------------------------------------------------

CREATE TABLE Modeles(
        mo_id   int (11) Auto_increment  NOT NULL ,
        mo_code Varchar (10) NOT NULL ,
        mo_nom  Varchar (15) NOT NULL ,
        PRIMARY KEY (mo_id ) ,
        UNIQUE (mo_code )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Tailles
#------------------------------------------------------------

CREATE TABLE Tailles(
        ta_Id   int (11) Auto_increment  NOT NULL ,
        ta_code Varchar (10) NOT NULL ,
        ta_nom  Varchar (25) NOT NULL ,
        PRIMARY KEY (ta_Id ) ,
        UNIQUE (ta_code )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: StocksArticles
#------------------------------------------------------------

CREATE TABLE StocksArticles(
        sa_id           int (11) Auto_increment  NOT NULL ,
        sa_ref          Varchar (25) NOT NULL ,
        sa_dateCreation Date NOT NULL ,
        sa_isActive     Bool NOT NULL ,
        ar_id           Int NOT NULL ,
        ta_Id           Int NOT NULL ,
        st_id           Int NOT NULL ,
        PRIMARY KEY (sa_id ) ,
        UNIQUE (sa_ref )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Destinataires
#------------------------------------------------------------

CREATE TABLE Destinataires(
        de_id         int (11) Auto_increment  NOT NULL ,
        de_ref        Varchar (25) NOT NULL ,
        de_nomClub    Varchar (25) NOT NULL ,
        de_nomContact Varchar (100) ,
        de_adresse1   Varchar (50) NOT NULL ,
        de_adresse2   Varchar (50) ,
        de_codePostal Varchar (10) NOT NULL ,
        de_ville      Varchar (50) ,
        de_pays       Char (2) ,
        de_IsClient   Bool NOT NULL ,
        de_isActive   Bool NOT NULL ,
        de_telephone  Varchar (25) ,
        de_email      Varchar (55) ,
        PRIMARY KEY (de_id ) ,
        UNIQUE (de_ref )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ExpeditionsArticles
#------------------------------------------------------------

CREATE TABLE ExpeditionsArticles(
        ea_id                   int (11) Auto_increment  NOT NULL ,
        ea_dateCreation         Date NOT NULL ,
        ea_realisePar           Char (5) ,
        ea_TrackingColis        Varchar (250) ,
        ea_nbArticleEnvoyeTotal Int NOT NULL ,
        ea_infoComplementaire   Text ,
        ea_isRetourIncomplet    Bool NOT NULL ,
        te_id                   Int NOT NULL ,
        de_id                   Int NOT NULL ,
        PRIMARY KEY (ea_id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TypesExpeditions
#------------------------------------------------------------

CREATE TABLE TypesExpeditions(
        te_id   int (11) Auto_increment  NOT NULL ,
        te_code Varchar (15) NOT NULL ,
        te_nom  Varchar (25) ,
        PRIMARY KEY (te_id ) ,
        UNIQUE (te_code )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Statuts
#------------------------------------------------------------

CREATE TABLE Statuts(
        st_id   int (11) Auto_increment  NOT NULL ,
        st_code Varchar (10) NOT NULL ,
        st_nom  Varchar (25) NOT NULL ,
        PRIMARY KEY (st_id ) ,
        UNIQUE (st_code )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: LotsArticles
#------------------------------------------------------------

CREATE TABLE LotsArticles(
        la_id         int (11) Auto_increment  NOT NULL ,
        la_dateRetour Date ,
        sa_id         Int NOT NULL ,
        ea_id         Int NOT NULL ,
        PRIMARY KEY (la_id)
)ENGINE=InnoDB;

ALTER TABLE Articles ADD CONSTRAINT FK_Articles_fa_id FOREIGN KEY (fa_id) REFERENCES Familles(fa_id);
ALTER TABLE Articles ADD CONSTRAINT FK_Articles_mo_id FOREIGN KEY (mo_id) REFERENCES Modeles(mo_id);
ALTER TABLE StocksArticles ADD CONSTRAINT FK_StocksArticles_ar_id FOREIGN KEY (ar_id) REFERENCES Articles(ar_id);
ALTER TABLE StocksArticles ADD CONSTRAINT FK_StocksArticles_ta_Id FOREIGN KEY (ta_Id) REFERENCES Tailles(ta_Id);
ALTER TABLE StocksArticles ADD CONSTRAINT FK_StocksArticles_st_id FOREIGN KEY (st_id) REFERENCES Statuts(st_id);
ALTER TABLE ExpeditionsArticles ADD CONSTRAINT FK_ExpeditionsArticles_te_id FOREIGN KEY (te_id) REFERENCES TypesExpeditions(te_id);
ALTER TABLE ExpeditionsArticles ADD CONSTRAINT FK_ExpeditionsArticles_de_id FOREIGN KEY (de_id) REFERENCES Destinataires(de_id);
ALTER TABLE LotsArticles ADD CONSTRAINT FK_LotsArticles_sa_id FOREIGN KEY (sa_id) REFERENCES StocksArticles(sa_id);
ALTER TABLE LotsArticles ADD CONSTRAINT FK_LotsArticles_ea_id FOREIGN KEY (ea_id) REFERENCES ExpeditionsArticles(ea_id);
