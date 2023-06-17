package za.co.code.campcleanup.adapter.impl;

import za.co.code.campcleanup.adapter.Adapter;
import za.co.code.campcleanup.domain.ImmutableSection;
import za.co.code.campcleanup.domain.ImmutableSectionPairs;
import za.co.code.campcleanup.domain.SectionPair;
import za.co.code.campcleanup.domain.SectionPairs;

import java.util.Arrays;

public class RawToSectionPairs implements Adapter<SectionPairs, byte[]> {

    @Override
    public SectionPairs adapt(byte[] bytes) {
        String campCleanUp = new String(bytes);

        String[] campCleanUpLines = campCleanUp.replace("\r", "")
                .split("\n");

        ImmutableSectionPairs.Builder sectionsPairsBuilder = ImmutableSectionPairs.builder();

        Arrays.stream(campCleanUpLines).forEach(c -> {
            String[] sections = c.trim().replace("-", ",").split(",");

            SectionPair sectionPair = SectionPair.builder()
                    .sectionOne(ImmutableSection.builder()
                            .start(Integer.parseInt(sections[0]))
                            .end(Integer.parseInt(sections[1]))
                            .build()
                    ).sectionTwo(ImmutableSection.builder()
                            .start(Integer.parseInt(sections[2]))
                            .end(Integer.parseInt(sections[3]))
                            .build()
                    ).build();

            sectionsPairsBuilder.addValue(sectionPair);
        });

        return sectionsPairsBuilder.build();
    }
}
