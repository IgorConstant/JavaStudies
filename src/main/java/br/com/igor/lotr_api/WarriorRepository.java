package br.com.igor.lotr_api;
import org.springframework.data.jpa.repository.JpaRepository;

interface WarriorRepository extends JpaRepository<Warrior, Long> {

}