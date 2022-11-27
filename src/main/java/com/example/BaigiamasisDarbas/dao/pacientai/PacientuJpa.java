package com.example.BaigiamasisDarbas.dao.pacientai;

import com.example.BaigiamasisDarbas.dto.Pacientas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacientuJpa extends JpaRepository<Pacientas, Long> {
}
