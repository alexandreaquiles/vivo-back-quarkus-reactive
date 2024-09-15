package br.com.vivo;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("/motivos")
public class MotivoResource {

    @GET
    public Uni<List<Motivo>> get() {
        return Motivo.listAll(Sort.by("titulo"));
    }

    @POST
    public Uni<RestResponse<Motivo>> create(Motivo motivo) {
      return Panache.withTransaction(motivo::persist)
        .replaceWith(RestResponse.status(RestResponse.Status.CREATED, motivo));
    }

}

