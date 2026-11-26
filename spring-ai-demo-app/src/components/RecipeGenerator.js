import React, { useState } from "react";

function RecipeGenerator(){
    const [ingredients, setIngredients] = useState('');
    const [cuisine, setCuisine] = useState('');
    const [dietaryRestrictions, setDietaryRestrictions] = useState('');
    const [recipe, setRecipe] = useState('');
    const createRecipe = async() => {
        try {
            const params = new URLSearchParams({ ingredients });
            if (cuisine.trim()) params.set('cuisine', cuisine.trim());
            if (dietaryRestrictions.trim()) params.set('dietaryRestrictions', dietaryRestrictions.trim());
            const response = await fetch(`http://localhost:8080/api/recipe/recipe-create?${params}`);
            const data = await response.text();
            if (!response.ok) {
                throw new Error(data || `Request failed with status ${response.status}`);
            }
            console.log(data);
            setRecipe(data);
        } catch (error) {
            console.error("Error generating recipe", error);
        }
    }
    return(
        <div>
            <h2>Create a Recipe</h2>
            <input
                type="text"
                value={ingredients}
                onChange={(e) => setIngredients(e.target.value)}
                placeholder="Enter the Ingredients(comma separated)"
            />

            <input
                type="text"
                value={cuisine}
                onChange={(e) => setCuisine(e.target.value)}
                placeholder="Enter the cuisine type"
            />

            <input
                type="text"
                value={dietaryRestrictions}
                onChange={(e) => setDietaryRestrictions(e.target.value)}
                placeholder="Enter the dietary restrictions"
            />

            <button onClick={createRecipe}>Create Recipe </button>

            <div className="output">
                <pre className="recipe-text">{recipe}</pre>
                <p>{recipe}</p>
            </div>

        </div>
        
    );
}

export default RecipeGenerator;
