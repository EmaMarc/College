program Parcial7;
const
    valoralto=9999;
    sucursales=20;
type
    producto=record
        codProducto=integer;
        Nombre=string;
        precio=real;
        stockActual=integer;
        stockMinimo=integer;
    end;

    maestro = file of producto;


    venta=record
        codProducto=integer;
        cantVendida=integer;
    end;

    detalle = file of venta;
    vec_Registros = Array[1..sucursales] of venta;
    vec_Detalles = Array[1..sucursales] of detalle;

procedure leer(var det:detalle; var dato:venta);
    begin
        if(not eof(det))
            read(mae,dato)
        else
            dato.codProducto:=valoralto;
    end;

procedure minimo(var vec_Detalles:vec_Detalles; var vec_Registros:vec_Registros; var min:venta);
    var
        i,iMin:integer;
    begin
        iMin:=0;
        min.codProducto:=valoralto;

        for i:= 1 to sucursales do begin
            if(vec_Registros.codProducto <> valorAlto) then begin
                if(vec_Registros.codProducto < min.codProducto) then begin
                    iMin:=i;
                    min:=vec_Registros[i];
                end;
            end;
        end;
        if(iMin <> 0) then begin
            leer(vec_Detalles[iMin],vec_Registros[iMin]);
        end;
    end;

procedure actualizar(var mae:maestro; var vec_Detalles:vec_Detalles; var txt:text);
    var
        p:producto;
        min:venta;
        vec_Registros:vec_Registros;
        i, codActual, totalComprados: integer;
    begin
        reset(mae); //Abro los archivos
        for i:= 1 to sucursales do begin
            reset(vec_Detalles[i])
            leer(vec_Detalles,vec_Registros);
        end;
        assing(txt,'ventas.txt');
        rewrite(txt);
        //↓↓↓↓ busco el menor y entro al while 
        minimo(vec_Detalles,vec_Registros,min);
        while(min.codigo <> valoralto) do begin
            codActual:=min.codProducto;//para preguntar si sigo leyendo el mismo prod
            totalComprados:=0;//inicializo total comprados del mismo prod
            while (min.codProducto = codActual) do begin
                totalComprados:=totalComprados + min.cantVendida;//sumatoria de todos los comprados
                minimo(vec_Detalles,vec_Registros,min);//busco el siguiente minimo
            end;//Me salgo del while cuando encuentro otro codigo

            read(mae,p);//↓↓↓↓ voy hasta el producto que modifique cargando todos p$ > 10000
            while(p.codProducto <> codActual)do begin
                if((totalComprados*p.precio) > 10000) then
                    writeln(txt,p.codProducto,' ',p.nombre,' ',p.precio,' ',p.stockActual,' ',p.stockMinimo);
                read(mae,p);
            end;
            //↓↓↓↓ modifico el stock de p, no puede haber stock negativo.
            if ((p.stockActual - totalComprados) < 0) then
                p.stockActual:=0
            else
                p.stockActual:=p.stockActual-totalComprados;

            seek(mae,filepos(mae)-1);//me posiciono donde esta el prod
            write(mae,p);// y le escribo el p modificado
        end;
    end;