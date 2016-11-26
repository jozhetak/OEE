<#include "Configs.java">
<#include "Macros.java">

    
    /**
     * Procesa las peticiones de carga asíncrona de datos a partir de un archivo CSV.
     *
     * @param ${main_class?uncap_first} ${main_class} al que pertenece la información.
     * @param newFilePath el parámetro new file path
     * @return La ruta a la vista principal de la aplicación.
     */
    @RequestMapping(value = "/procesaCSV", method = RequestMethod.GET)
    public String uploadCSV(
            @ModelAttribute("${main_id}") ${main_class} ${main_class?uncap_first},
            @ModelAttribute(MODEL_ATTRIBUTE_CSVFILE) String newFilePath) {
        String nuevaRuta;
        if (${main_class?uncap_first} != null && newFilePath != null) {
            LOGGER.debug("cargando Plantas del Archivo: {}", newFilePath);
            Reader reader = CsvUtils.generaReader(newFilePath);
            CsvClient<${object}DTO> csvClient
                    = new CsvClientImpl<>(reader, ${object}DTO.class);
            List<${object}DTO> listaDTOs = csvClient.readBeans();
            List<Long> idsList
                    = ${object?uncap_first}Mapper.findAllIdsByIdEscenario(${main_class?uncap_first}.getId());
            for (${object}DTO dto : listaDTOs) {
                ${object} dao${object}
                        = ${object?uncap_first}Mapper.findByIdEscenarioAndCodigo(
                                ${main_class?uncap_first}.getId(), dto.getCodigo());
                A02Regiones daoA02Regiones
                        = a02RegionesMapper.findByIdEscenarioAndCodigo(
                                ${main_class?uncap_first}.getId(), dto.getCodigoRegionControl());
                Long idRegionControl = daoA02Regiones != null ? daoA02Regiones.getId() : null;
                if (dao${object} != null) { // update
                    dao${object}.setDescripcion(dto.getDescripcion());
                    dao${object}.setIdRegionControl(idRegionControl);
                    ${object?uncap_first}Mapper.update(dao${object});
                    idsList.remove(dao${object}.getId());
                } else { // insert
                    dao${object} = ${object}.getBuilder()
                            .idEscenario(${main_class?uncap_first}.getId())
                            .codigo(dto.getCodigo())
                            .descripcion(dto.getDescripcion())
                            .idRegionControl(idRegionControl)
                            .build();
                    ${object?uncap_first}Mapper.insert(dao${object});
                }
            }
            if (idsList.size() > 0) {
                ${object?uncap_first}Mapper.deleteAllById(idsList);
            }
            nuevaRuta = String.format("/${main_id}/%d/${id_name}", ${main_class?uncap_first}.getId());
        } else {
            nuevaRuta = "/${id_name}";
        }
        return createRedirectViewPath(nuevaRuta);
    }
