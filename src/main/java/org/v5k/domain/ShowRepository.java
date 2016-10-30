package org.v5k.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.v5k.domain.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
