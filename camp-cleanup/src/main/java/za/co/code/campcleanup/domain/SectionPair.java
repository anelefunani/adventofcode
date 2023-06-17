package za.co.code.campcleanup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SectionPair {
    private Section sectionOne;
    private Section sectionTwo;
}
