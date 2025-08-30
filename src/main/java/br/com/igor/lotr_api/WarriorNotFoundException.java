package br.com.igor.lotr_api;

class WarriorNotFoundException extends RuntimeException {

    WarriorNotFoundException(Long id) {
        super("Não foi possível encontrar o Guerreiro de LOTR" + id);
    }
}