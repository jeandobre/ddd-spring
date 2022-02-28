package dddspring.common;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public final class ResponseEntityHeader {

    public static ResponseEntity<Object> bodyAndHeaders(Page pageReferral) {
        return ResponseEntity.ok()
                .header("page", String.valueOf(pageReferral.getPageable().getPageNumber()))
                .header("pageSize", String.valueOf(pageReferral.getPageable().getPageSize()))
                .header("totalPage", String.valueOf(pageReferral.getTotalPages()))
                .header("count", String.valueOf(pageReferral.getNumberOfElements()))
                .header("total", String.valueOf(pageReferral.getTotalElements()))
                .body(pageReferral.getContent());
    }
}
