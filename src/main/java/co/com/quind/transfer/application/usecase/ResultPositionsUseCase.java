package co.com.quind.transfer.application.usecase;

import co.com.quind.transfer.application.port.out.PositionRepository;
import co.com.quind.transfer.domain.models.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ResultPositionsUseCase {
    private static final Logger logger = LoggerFactory.getLogger(ResultPositionsUseCase.class);
    private final PositionRepository repository;

    public ResultPositionsUseCase(PositionRepository repository) {
        this.repository = repository;
    }

    public List<Position> getResults() {
        logger.info("Fetching all positions results");
        return this.repository.getAllPositions();
    }

}
