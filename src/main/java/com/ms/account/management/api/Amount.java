package com.ms.account.management.api;

import com.ms.account.management.common.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Amount {
    @Pattern(regexp = RegexConstants.CURRENCY_CODE)
    @Size(min = 3, max = 3)
    private String currencyCode;
    @Pattern(regexp = RegexConstants.CURRENCY)
    @Size(max = 32)
    private String value;
}
