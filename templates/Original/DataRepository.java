<#--
A built-in Freemarker template (see http://freemarker.sourceforge.net) used for
filling the body of methods generated by the IDE. When editing the template,
the following predefined variables, that will be then expanded into
the corresponding values, could be used together with Java expressions and
comments:
${package} fully qualified name of the package
${object} the POJO for which the class is created
${fields} names of all the fields
${fieldsAndModifiers} modifier, type, and naame of all the fields
${fieldElems} field elements
-->
package ${package};

import java.util.List;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ${object}DataRepository extends EntityRepository<${object}, Long> {

}