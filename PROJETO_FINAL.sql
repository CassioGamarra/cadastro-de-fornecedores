#COMANDOS SQL#

create database cadastro_fornecedores
default character set utf8mb4
default collate utf8mb4_general_ci

#TABELA FORNECEDORES#
#Obs: o telefone possui um tamanho grande pois alguns fornecedores posssuem mais de um telefone#

create table fornecedor(
	id_fornecedor int unsigned not null auto_increment,
	cnpj varchar(30) not null,
	nome varchar(255) not null,
	telefone varchar(100) not null,
	cep varchar(12) not null,
	endereco varchar(255) not null,
	bairro varchar(50) not null,
	municipio  varchar(100) not null,
	uf varchar(3) not null,
	status tinyint(1) not null,
	primary key(id_fornecedor)
)default character set utf8mb4;

