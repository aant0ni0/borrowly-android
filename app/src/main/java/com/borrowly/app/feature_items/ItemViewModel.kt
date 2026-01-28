import com.borrowly.app.feature_items.data.ItemRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borrowly.app.feature_items.ItemUiState
import com.borrowly.app.feature_items.data.ItemRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {

    private val repository: ItemRepository = ItemRepositoryImpl()

    private val _uiState = MutableStateFlow(ItemUiState(isLoading = true))
    val uiState: StateFlow<ItemUiState> = _uiState

    init {
        loadItems()
    }

    fun loadItems() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true)
                val items = repository.getItems()
                _uiState.value = ItemUiState(items = items)
            } catch (e: Exception) {
                _uiState.value = ItemUiState(error = e.message)
            }
        }
    }
}
