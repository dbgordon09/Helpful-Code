import kotlin.reflect.KClass

data class LauncherListItem(val heading: String, val activityToLaunch: KClass<*>)