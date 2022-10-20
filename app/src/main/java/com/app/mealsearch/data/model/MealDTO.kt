package com.app.mealsearch.data.model

import com.app.mealsearch.domain.model.Item
import com.app.mealsearch.domain.model.Meal
import com.app.mealsearch.domain.model.MealDetails

data class MealDTO(
    val idMeal: String,
    val dateModified: String?,
    val strArea: String?,
    val strCategory: String?,
    val strCreativeCommonsConfirmed: String?,
    val strDrinkAlternate: String?,
    val strImageSource: String?,
    val strIngredient1: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient16: String?,
    val strIngredient17: String?,
    val strIngredient18: String?,
    val strIngredient19: String?,
    val strIngredient2: String?,
    val strIngredient20: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strInstructions: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strMeasure1: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strMeasure16: String?,
    val strMeasure17: String?,
    val strMeasure18: String?,
    val strMeasure19: String?,
    val strMeasure2: String?,
    val strMeasure20: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strSource: String?,
    val strTags: String?,
    val strYoutube: String?
)

fun MealDTO.toDomainMeal(): Meal {
    return Meal(
        id = this.idMeal,
        name = this.strMeal ?: "",
        image = this.strMealThumb ?: ""
    )
}

fun MealDTO.toDomainMealDetails(): MealDetails {
    val list:MutableList<Item> = mutableListOf()

    strIngredient1?.let { it ->
        strMeasure1?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient2?.let { it ->
        strMeasure2?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient3?.let { it ->
        strMeasure3?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient4?.let { it ->
        strMeasure4?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient5?.let { it ->
        strMeasure5?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient6?.let { it ->
        strMeasure6?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient7?.let { it ->
        strMeasure7?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient8?.let { it ->
        strMeasure8?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient9?.let { it ->
        strMeasure9?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient10?.let { it ->
        strMeasure10?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient11?.let { it ->
        strMeasure11?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient12?.let { it ->
        strMeasure12?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient13?.let { it ->
        strMeasure13?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient14?.let { it ->
        strMeasure14?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient15?.let { it ->
        strMeasure15?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient16?.let { it ->
        strMeasure16?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient17?.let { it ->
        strMeasure17?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient18?.let { it ->
        strMeasure18?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient19?.let { it ->
        strMeasure19?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }
    strIngredient20?.let { it ->
        strMeasure20?.let { it1 ->
            if(it.isNotEmpty() && it1.isNotEmpty())
                list.add(Item(it, it1))
        }
    }


    return MealDetails(
        id = this.idMeal,
        name = this.strMeal ?: "",
        image = this.strMealThumb ?: "",
        instructions = this.strInstructions ?: "",
        list
    )
}