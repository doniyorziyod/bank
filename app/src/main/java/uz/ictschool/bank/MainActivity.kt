package uz.ictschool.bank

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uz.ictschool.bank.ui.theme.BankTheme
import uz.ictschool.bank.ui.theme.BiometricPromtManager
import uz.ictschool.bank.ui.theme.BiometricPromtManager.*

class MainActivity : AppCompatActivity() {
    private val promtManager by lazy {
        BiometricPromtManager(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val biometricResult by promtManager.promptResults.collectAsState(initial = null)
                    val enrollLauncher= rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
                        
                    }
                    LaunchedEffect(key1 = biometricResult) {
                        if (biometricResult is BiometricResult.AuthenticationNotSet){
                            if (Build.VERSION.SDK_INT>=30){
                                val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                                    putExtra(
                                        Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                                        BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                                    )
                                }
                            }
                        }
                    }
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ){
                        Button(onClick = {
                            promtManager.showBiometricPrompt("Sample Prompt","description of Prompr")
                        }) {
                            Text(text = "Authenticate")

                        }
                        biometricResult?.let { result->
                            Text(text = when(result){
                                is BiometricResult.AuthenticationError -> "Authentication Error ${result.error}"
                                BiometricResult.AuthenticationFailed -> "Authentication Failed"
                                BiometricResult.AuthenticationNotSet -> "Authentication not set"
                                BiometricResult.AuthenticationSucces -> " Authentication Succes"
                                BiometricResult.FeatureUnaviable -> "Feature Unvailuble"
                                BiometricResult.HardUnaviable -> "HArdware unvailable"
                            }
                            )

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankTheme {
        Greeting("Android")
    }
}