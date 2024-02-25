package co.com.quind.transfer.infrastructure.adapter.postgres;

import co.com.quind.transfer.application.port.out.PositionRepository;
import co.com.quind.transfer.domain.models.Position;
import co.com.quind.transfer.infrastructure.adapter.postgres.models.PositionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PositionPostgresqlAdapter implements PositionRepository {

    private static final Logger logger = LoggerFactory.getLogger(EmployerPostgresqlAdapter.class);
    private final PositionDbRepository positionDbRepository;


    /**
     * Constructor for dependency injection of the PositionPostgresqlAdapter.
     * @param positionDbRepository The Employer repository interface for crud.
     */
    public PositionPostgresqlAdapter(PositionDbRepository positionDbRepository) {
        this.positionDbRepository = positionDbRepository;
    }

    @Override
    public List<Position> getAllPositions() {
        return this.positionDbRepository
                .findAll()
                .stream()
                .map(PositionEntity::toDomain)
                .collect(Collectors.toList());
    }
}
