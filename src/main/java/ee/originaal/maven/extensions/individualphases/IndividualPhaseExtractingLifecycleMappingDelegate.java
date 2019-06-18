package ee.originaal.maven.extensions.individualphases;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.lifecycle.Lifecycle;
import org.apache.maven.lifecycle.LifecycleMappingDelegate;
import org.apache.maven.lifecycle.internal.DefaultLifecycleMappingDelegate;
import org.apache.maven.plugin.InvalidPluginDescriptorException;
import org.apache.maven.plugin.MojoExecution;
import org.apache.maven.plugin.MojoNotFoundException;
import org.apache.maven.plugin.PluginDescriptorParsingException;
import org.apache.maven.plugin.PluginNotFoundException;
import org.apache.maven.plugin.PluginResolutionException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;

@Component(role = LifecycleMappingDelegate.class, hint = DefaultLifecycleMappingDelegate.HINT)
public class IndividualPhaseExtractingLifecycleMappingDelegate extends DefaultLifecycleMappingDelegate {

    @Override
    public Map<String, List<MojoExecution>> calculateLifecycleMappings(MavenSession session, MavenProject project, Lifecycle lifecycle, String lifecyclePhase)
            throws PluginNotFoundException, PluginResolutionException, PluginDescriptorParsingException, MojoNotFoundException, InvalidPluginDescriptorException {

        return super.calculateLifecycleMappings(session, project, lifecycle, lifecyclePhase)
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(lifecyclePhase))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
