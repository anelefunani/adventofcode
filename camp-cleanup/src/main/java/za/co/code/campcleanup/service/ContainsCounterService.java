package za.co.code.campcleanup.service;

import za.co.code.campcleanup.domain.FullyContains;
import za.co.code.campcleanup.domain.SectionPairs;

public interface ContainsCounterService {
     FullyContains count(SectionPairs sectionPairs);
}
