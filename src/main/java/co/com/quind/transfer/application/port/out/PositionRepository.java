package co.com.quind.transfer.application.port.out;

import co.com.quind.transfer.domain.models.Position;

import java.util.List;

public interface PositionRepository {
    List<Position> getAllPositions();
}
