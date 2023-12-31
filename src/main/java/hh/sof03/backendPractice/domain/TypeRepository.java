package hh.sof03.backendPractice.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {

	List<Type> findByTypeName(String typeName);
}
