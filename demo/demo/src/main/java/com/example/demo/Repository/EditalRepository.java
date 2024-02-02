package com.example.demo.Repository;

import com.example.demo.Model.Edital;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/Editais")
public class EditalRepository implements JpaRepository<Edital, Long> {

    @GetMapping
    @Override
    public List<Edital> findAll() {
        return null;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> S save(S entity) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends com.example.demo.Model.Edital> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Edital> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Edital getOne(Long aLong) {
        return null;
    }

    @Override
    public Edital getById(Long aLong) {
        return null;
    }

    @Override
    public Edital getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends com.example.demo.Model.Edital> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends com.example.demo.Model.Edital> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends com.example.demo.Model.Edital, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }


    @Override
    public <S extends com.example.demo.Model.Edital> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Edital> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }



    @Override
    public List<Edital> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Edital entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Edital> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Edital> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Edital> findAll(Pageable pageable) {
        return null;
    }
}
