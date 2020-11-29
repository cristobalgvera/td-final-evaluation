package cl.crisgvera.tdapi.common;

import org.springframework.data.jpa.repository.JpaRepository;

import static cl.crisgvera.tdapi.common.ServiceConstant.ENTITY_WITH_ID;

public class Util {
    static void checkExistence(Long id,
                               JpaRepository<?, Long> jpaRepository,
                               boolean existenceNecessity) {
        String NECESSITY_MESSAGE = existenceNecessity ? " does not exist." : " already exist.";
        boolean exist = jpaRepository.existsById(id);

        assert exist == existenceNecessity : ENTITY_WITH_ID + id + NECESSITY_MESSAGE;
    }
}
