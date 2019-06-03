package com.example.examenb1javier

import android.os.Parcel
import android.os.Parcelable

class Ingredientes(var id:Int?,
                   var nombreIngrediente:Int,
                   var cantidad:String,
                   var descripcionPreparacion:String,
                   var opcional:String,
                   var tipoIngrediente:String,
                   var necesitaRefrigeracion:Int,
                   var comidaId:Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }
/*
    override fun toString(): String {
        //  return "Número Camiseta: ${nombreIngrediente} Nombre Ingredientes: ${descripcionPreparacion} Poder: ${opcional} Fecha Ingreso:${tipoIngrediente} Goles:${necesitaRefrigeracion}"
        return "$cantidad necesitaRefrigeracion: $necesitaRefrigeracion"
    }
*/


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeInt(nombreIngrediente)
        parcel.writeString(cantidad)
        parcel.writeString(descripcionPreparacion)
        parcel.writeString(opcional)
        parcel.writeString(tipoIngrediente)
        parcel.writeInt(necesitaRefrigeracion)
        parcel.writeInt(comidaId)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "id=$id, nombreIngrediente=$nombreIngrediente, cantidad='$cantidad', descripcionPreparacion='$descripcionPreparacion', opcional='$opcional', tipoIngrediente='$tipoIngrediente', necesitaRefrigeracion=$necesitaRefrigeracion, comidaId=$comidaId"
    }

    companion object CREATOR : Parcelable.Creator<Ingredientes> {
        override fun createFromParcel(parcel: Parcel): Ingredientes {
            return Ingredientes(parcel)
        }

        override fun newArray(size: Int): Array<Ingredientes?> {
            return arrayOfNulls(size)
        }
    }
}
