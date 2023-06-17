package za.co.code.campcleanup.service;

import za.co.code.campcleanup.domain.Count;
import za.co.code.campcleanup.domain.SectionPairs;

public interface ContainsCounterService {
     Count count(SectionPairs sectionPairs);
}
